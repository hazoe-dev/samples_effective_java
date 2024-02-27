# Thread được ứng dụng như thế nào trong swing

## Đặt vấn đề:

- Với những phần tương tác với giao diện ta phải đảm bảo tính phản hồi trên giao diện mượt mà.
- Swing GUI cần chạy trên 1 UI thread duy nhất (Event dispatch thread - EDT) vì cần:
    - Thay đổi được cập nhật trên nhiều giao diện đồng nhất
    - Luôn đảm bảo kết quả đoán định được, đúng mọi lúc
    - Nếu dùng multiple threads thì sẽ rất phức tạp trong xử lý đồng bộ
    - Event dispatch thread là thread quản lý sự kiện và cập nhật component hiển thị nên thường chỉ có những xử lý đơn giản và nhanh chóng
- Vậy làm sao mà chạy mượt nếu chỉ có 1 thread mà không bị đứng (hang: không phản hổi, chờ) cho những xử lý khác nếu không chỉ là xử lý giao diện.

- Swing cho chúng ta:
    - SwingWorker: tách những nhiệm vụ chạy tốn thời gian mà không cần dùng UI ra một luồng khác thực thi
    - SwingUtilities.invokeLater: cho phép ta tương tác với UI thread từ thread khác

### SwingWorker:

1. Mục đích: Để tránh tình huống UI bị treo, không phản hồi những task tốn thời gian được thực thi trên thread khác,
   để thread UI được chạy liên tục với những nhiệm vụ đơn giản một cách nhanh chóng

2. Giải thích cách thức  
   Ứng dụng multiple threads vào bài toán swing chỉ có 1 UI thread:
- Không phải UI task nào cũng phức tạp và chạy lâu, vì những thao tác xử lý event của UI component thường đơn giản và
  có thể thực hiện nhanh chóng.   
  Ví dụ: bạn click vào một button thì bảng bên cạnh nó sẽ được ẩn đi
- Với những task mà không chỉ tương tác với UI, ta còn cần cập nhật database, call service ...  
  Thì thời gian sẽ lâu hơn rất nhiều vì ta phải đợi phản hồi từ máy khác hay quá trình xử lý phức tập
  rồi mới xử lý phần UI phản hồi lại user sau đó chẳng hạn.
    - Phần lâu đó có thể đến từ mạng không ổn định khi call service, logic xử lý phức tạp,
      quá trình lưu data lâu khi database thuộc một lab khác, hay
      nếu bạn đang dùng hệ quản trị cơ sở dữ liệu quan hệ (RDBMS) thì có thể còn phụ thuộc vào các mức độ isolation mà bạn đang dùng, vv...
    - Với loại task thứ 2 này mình có thể chia nhỏ task thành nhiều phần hơn:
        - Task UI thì nhanh
        - Task xử lý thì tốn thời gian, ta để nó chạy ngầm trên một luồng khác
            - Nhưng sau khi chia, ta lại có những nhu cầu khác với background task này:
            - 1, Không cần quan tâm đến kết quả trả về
            - 2, Cần nhận kết quả trả về sau cùng
            - 3, Cần nhận trạng thái cập nhật từng giai đoạn

=> Đáp ứng những nhu cầu trên, swing support SwingWorker.
- SwingWorker: cung cấp một luồng mới ngoài UI thread cho task xử lý lâu
- Nếu bạn không quan tâm đến kết quả trả về -> bạn chỉ cần implement doInBackground()
- Nếu bạn muốn nhận kết quả sau cùng để cập nhật UI -> bạn chỉ cần implement thêm done() ngoài doInBackground()
- Nếu bạn muốn nhận trạng thái trong từng giai đoạn để cập nhật UI process -> bạn chỉ cần implement thêm process() ngoài doInBackground()

3. Cách dùng
- Bạn cần định nghĩa kiểu trả về cho method done và process khi new object implement SwingWorker
- Muốn lấy kết quả sau cùng của doInBackground trong done, bạn gọi get()
- Muốn lấy kết quả trạng thái của doInBackground trong process, bạn call publish và truyền vào trạng thái thông báo,
  bạn lấy được danh sách data đã publish trong argument của process()
- Vì SwingWorker là một thread nên chỉ được thực thi sau khi start, ở đây chính là call execute() method để bạn start
  background worker thread.

4. Ví dụ

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SwingWorkerExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("SwingWorker Example");
        JButton button = new JButton("Fetch Data");
        JProgressBar progressBar = new JProgressBar(0, 10);
        progressBar.setStringPainted(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When the button is clicked, start a background worker task
                // specifying the types for the result and intermediate results if needed
                new SwingWorker<String, Integer>() {
                    @Override
                    protected String doInBackground() throws Exception {
                    // This code runs in the background thread
                    // a time-consuming task (e.g fetching data from a server)
                        for (int i = 1; i <= 10; i++) {
                            // Simulate a time-consuming task
                            Thread.sleep(500);
                            // Publish interim results
                            publish(i);
                        }
                        return "Data fetched successfully!";
                    }
                    @Override
                    protected void process(List<Integer> chunks) {
                        // This code runs on the EDT
                        // can process interim results
                        for (Integer progress : chunks) {
                            progressBar.setValue(progress);  // Update UI with interim result
                        }
                    }

                    @Override
                    protected void done() {
                        try {
                            //This code runs on the EDT
                            // Update UI with the result when the background task is done
                            // Get the final result
                            JOptionPane.showMessageDialog(frame, get());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    //starts the background task
                }.execute();
            }
        });

        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(button);
        frame.getContentPane().add(progressBar);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

Note:
Ta thấy rằng SwingWorker support 2 thread khác nhau, một cái là UI thread một cái là background worker thread.  
Vậy làm sao 2 thread này giao tiếp với nhau?
- Chính là nhờ SwingUtilities.invokeLater được gọi trong done() và process()

### SwingUtilities.invokeLater:

1. Mục đích:
- Giúp bạn dù đứng ở thread nào cũng sẽ đều thực thi được code trên UI thread.
- Đảm bảo code bạn sử dụng với Swing component luôn được chạy trên UI thread (EDT).

2. Giải thích cách thức
- Vì trong API của method trên, nhận vào 1 object implement Runnable, cái mà sẽ được add vào Event queue của UI thread nên
  code trên object này sẽ có thể được chạy trên UI thread


3. Cách dùng
- Thường dùng khi bạn xử lý xong một task tốn thời gian ở thread chạy ngầm khác _ cái không phải UI thread
  và bạn muốn cập nhật Swing component trên UI thread.
- Bạn call SwingUtilities.invokeLater, bỏ vào method này một object của class implement Runnable, đưa code bạn muốn xử lý
  vào hàm run().

4. Ví dụ

```java

import javax.swing.*;

public class InvokeLaterExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("InvokeLater Example");
        JButton button = new JButton("Update UI");

        button.addActionListener(e -> {
            // Perform a time-consuming task in a background thread
            new Thread(() -> {
                // Simulate a time-consuming task (e.g., complex computation)
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // Update UI on the EDT using invokeLater
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(frame, "UI updated after background task.");
                });
            }).start();
        });

        frame.getContentPane().add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

### ActionListener:
Cũng tương tự như SwingUtilities.invokeLater, SwingWorker, ActionListener cũng handle task trên UI thread
1. Mục đích:
- Xử lý những sự kiện tương tác với UI component
2. Giải thích cách thức
- Xử lý trong actionPerform sẽ được đẩy vào Queue event sau khi user thao tác trên component.
  Ví dụ như click vào một button
3. Cách dùng
- Add ActionListener vào component, implement actionPerform method
4. Ví dụ

```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("ActionListener Example");
        JButton button = new JButton("Click me");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform an action when the button is clicked
                JOptionPane.showMessageDialog(frame, "Button Clicked!");
            }
        });

        frame.getContentPane().add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

```
## Mối quan hệ giữa SwingUtilities.invokeLater, SwingWorker and ActionListener
- Khi tương tác với các UI component bằng ActionListener, bạn sẽ gặp rắc rối nếu nhiệm vụ mà action ấy xử lý quá tốn thời gian.
  Vì bạn chỉ đang work trên một UI thread duy nhất và dẫn đến giao diện người dùng không phản hồi.
- Vì vậy, SwingWorker ra đời giúp bạn xứ lý task tốn thời gian ở một thread khác.
  Nhưng lại có một vấn đề khác, bạn muốn đồng bộ kết quả ở worker thread với UI thread.
- Vậy là ta có SwingUtilities.invokeLater hỗ trợ SwingWorker quá trình đồng bộ worker thread và UI thread.

### Compare SwingUtilities.invokeLater, SwingWorker and ActionListener

Cũng tương tự như SwingUtilities.invokeLater, SwingWorker một xử lý trên swing có thể được xử lý trên actionListener,
vậy những khái niệm này có gì giống và khác nhau trong swing:

|             | SwingWorker                                                                                                                                                                                                                                                                                                                                                                                                        | SwingUtilities.invokeLater                                                                                                                                                                                                            | ActionListener                                               |  
|-------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-------------------------------------------------------------|
| Type        | Abstract class                                                                                                                                                                                                                                                                                                                                                                                                     | Interface                                                                                                                                                                                                                             | Interface                                                    |
| Chức năng   | Chạy ngầm 1 task phức tap / mất nhiều thời gian trên 1 thread khác <br/>, xử lý phản hồi trả về cho UI thread                                                                                                                                                                                                                                                                                                      | Cho phép một thread ngoài UI thead có thể chạy được trên UI thread                                                                                                                                                                    | Xử lý event của component trên UI thread                     |
| Sử dụng     | - Anonymous inner class: Nếu chỉ dùng một lần, và cần truy cập member variables của GUI class mà không cần export ra ngoài<br/> - Inner class: trong 1 class mình muốn reuse cho nhiều method khác trong cùng class dùng và muốn truy cập member variables của GUI class mà không cần export </br> - A new class: can reuse for many classes, nhưng bạn phải export member variables của GUI classes bạn muốn dùng | Like SwingWorker                                                                                                                                                                                                                      | Like SwingWorker                                             |
| Ưu điểm     | - Giải guyết bài toán hiệu suất bằng cách tách task tốn thời gian sang một thread khác để thực hiện được chạy đồng thời với đa luồng                                                                                                                                                                                                                                                                               | Đảm bảo code được chạy trên UI thread từ bất kì thread nào khác, cách dùng đơn giản                                                                                                                                                   | Xử lý event của component, cách dùng đơn giản                |
| Nhược điểm  | - Sử dụng phức tạp hơn, cần hiểu rõ method nào chạy trên thread nào và khi nào dùng method đó </br> - Tốn tài nguyên vận hành 2 threads khác nhau </br> - Có khả năng bị deadlock nếu dùng không đúng cách vì đang lập trình multiple threads                                                                                                                                                                    | - Có thể làm UI hang: nếu task quá tốn thời gian sẽ làm giảm hiệu suất <br/> - Không nhận được kết quả trả về đồng bộ như SwingWorker </br> - Có khả năng bị deadlock nếu dùng không đúng cách vì đang lập trình multiple threads   | Chạy đơn luồng với UI thread, có thể bị hang, không phản hồi |

- ??? Cần kiểm tra lại về deadlock được đề cập ở trên
