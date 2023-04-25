# Method equals(),  hashCode() và HashMap
## Equals()
Chúng ta cùng tìm hiểu về equals():  
Là một phương thức được hiện thực sẵn trong class Object của java.
### Vậy thì khi nào mình nên và không nên override lại?

Khi bạn muốn so sánh bằng giữa 2 instances thì mình có thể có 2 kiểu kiểm tra:  
- Identity: 2 instances khác nhau thì khác nhau, tức là 2 objects này trỏ đến 2 địa chỉ nhớ khác nhau thì khác nhau
- Logical equality - value classes: bạn muốn so sánh về giá trị, tức là các value properties giữa chúng xem có giống nhau không.  
=>
Vậy:  
Với kiểu identity, bạn dùng default equals method.  
Với kiểu value classes, bạn nên override nó.

### Cụ thể
1. Sử dụng  default equals method  
   1. Each instance is unique: Vd: Thread không quan tâm values, active entities > value.  
   2. Don’t care about providing a “logical equality”: vd: Random, mỗi lần new Random, thì class này cần check xem có trùng với cái trước đó không. Khi dùng bạn không quan tâm đến điều này.  
   3. Overriding equals has existed in the superclass and approciated.  
   4. Private class, this method is never invoked.
2. Overriding equals  
   Phải tuân thủ general contract:
   1. Reflective: x.equals(x) = true
   2. Symmetric:  x.equals(y) = true =>  y.equals(x) = true
   3. Transitive: x.equals(y) = true && y.equals(z) = true =>  x.equals(z) = true
   4. Consistent: x.equals(y) = true =>  always nếu không có gì bị modify
   5. Not null: x.equals(null) = false
### Lưu ý
   Hiệu xuất của equals có thể phụ thuộc vào properties bạn dùng để compare.
####   Với Symmetric, bạn có thể bị vi phạm khi dùng inheritance
   Example:

Coding ….


Fix = compositions -> Favor composition over inheritance

Coding …

### Liên hệ:
Bạn dùng nó khi bạn muốn so sánh bằng về giá trị giữa 2 đối tượng. Hay cụ thể hơn, bạn kiểm tra trong một tập hợp, có phần tử nào đã thêm trùng với giá trị bạn đang thêm.  
Nó giống như là Key trong Set.  
Hay dùng nó trong một bài toán phân loại. Ví dụ: các lớp, các loài, chi , họ.  

## Hashcode()
Về hashCode():  
Đây là một phương thức được hiện thực sẵn trong class Object của java.  
Ví dụ:

Coding …

Bạn không thể lấy ra thông tin đã put(), tại sao?  
### Rule
Đó là lý do có quy tắc sau:  
**“Always override hashCode when you override equals.”**   
Nếu bạn đã override equals bạn buộc phải override hashCode, nếu không bạn sẽ gặp bugs với **hash-based collections** chẳng hạn như HashMap, HashSet, HashTable.

Nếu bạn không dùng đến hash thì mọi thứ vẫn ổn, cho đến một ngày bạn dùng HashMap và bị lỗi ở đâu đó, nó dường như thật khó để tìm ra.  
Vậy thì giải pháp là hãy làm nó đúng ngay từ đầu. Hãy đặt những viên gạch vuông vức, vững trãi nhất có thể, để về sau bạn chỉ tập trung với những vấn đề khác tốt hơn  và ít công sức hơn.  

### Contract cho hashCode bao gồm:
1. The same object is invoked more than once during an execution of an application, the hashCode must consistently return the same integer. On different executions of an application, it can be different from each other.
2. Two objects equal according to the equals() must have the same hashCode number.
3. But two objects that do not equal, they maybe have the distinct hashCode number.

Nhưng nếu bạn đảm bảo được khi 2 objects không bằng nhau thì hashCode khác nhau sẽ tăng hiệu suất cho **search of hashtable.**  
### Lưu ý:
Khi bạn hiện thực hashCode bạn có thể trả về cùng một constant nhưng nó mới chỉ đảm bảo yếu tố 1, 2.  
Khi đảm bảo được cả 3, thì đó là 1 hàm hashcode tốt.  
#### Recipe hashCode
Đây là công thức gợi ý cho good hashCode được nhắc đến:  
1. Chọn 1 số tùy ý, là 1 constant vd: 17  
2. Với mỗi significant field, bạn tính ra một giá trị: vd bạn có field f và kiểu là   
   - byte, char, short, int -> (int)f
   - boolean -> f?1:0
   - long -> (int)(f^(f>>>32))
   - float -> Float.floatToIntBits(f)
   - double -> Double.doubleToIntBits(f)
   - reference -> đệ quy cho properties, nếu phức tạp có thể là constant
   - array-> tính hashcode từng element (vd ra giá trị c)-> combine = [result = 31 * result +c]
3. Return
4. Test  
Qua đây ta thấy, hash code được tính từ từng phần nhỏ của 1 object nên nó tên hash (băm).
### Liên hệ:
Kết luận rằng equals() liên kết với hashCode().  
Mỗi method có lý do để nó ở đó và giờ mình biết hashCode() là bạn của equals().  
Mời equals phải mời hashCode hoặc không mời cả hai!  
## HashMap
Trước nhất ta điểm qua bạn Map.  
### Map
Cấu trúc dữ liệu tập hợp của các Entry chứa 1 cặp key-value.  
Gồm các class hiện thực:  
- Hashtable: không có null, hỗ trợ đồng bộ
- HashMap: ngược lại của bé 1, có bé con LinkedHashMap
- SortedMap có hiện thực là TreeMap

### HashMap
Vậy giờ, đến HashMap nha!  
Cấu trúc gồm các Buckets là các LinkedList.  
Bucket chứa các Node.  
Node gồm Key, Value, int hash, Node<K,V> next.  

Mô hình của HashMap
….

#### Methods:
##### put(node)
1. Tính hashCode key của node
2. Tính index: hashCode&(n-1)  
Với n là size của HashMap, default là 16 (0-15)  
Vd: index =4 
Nếu bucket 4 không có node thì lưu node vào index=4 trong HashMap collection.  
Ngược lại, tiếp tục.  
3. Hash collision: Nhiều key cùng index. Tính hashcode của chúng, dùng equals to compare equal.  
Nếu bằng thì thay thế.  
Nếu không thì liên kết với node đã tồn tại dạng LinkedList, set next là null.  
##### get(key)
1. Tính hashCode của key
2. Tính index
3. Compare  key bằng equals với first element trong bucket.  
 Nếu bằng, trả giá trị value. Ngược lại, check next nếu có để check tiếp. Không có trả null.

Như vậy là có giảm thiếu số lần search, về dựa vào index tình từ hashCode. Thay vì search all phần từ thành n buckets, sau đó là tìm trong một bucket.

	

















