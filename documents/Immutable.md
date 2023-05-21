# Immutable
## What is it?
- Là một class mà không được thay đổi nội tại (state/attributes) ngay sau khi được tạo ra.
- Bạn có thể làm 1 số cách sau để đảm bảo được điều trên:
  - Khai báo private hay private final cho các attributes
  - Không có method setter - cái có thể thay đổi bất kì attributes nào.
  - Bạn có thể để class là final -> để không được kế thừa hay override lại method của mình.  

=> Vậy nên, nếu muốn 1 giá trị mới / state thay đổi, bạn phải new một object mới cho ẻm.

## Cách dùng

Mutable:  
``
    List<String> list = new ArrayList<String>();
    list.add("Ha");
``

Immutable:  
`MyList<String> list = new MyList<String>();`  
`list = list.add("Ha");`

Bạn phải gán lại giá trị object mới trong immutable.

## Lợi ích
Sharing object safely => safe thread
- Bạn không cần dùng synchronize nữa.

Side effect free.

## Hạn chế
- Bạn không biết cách dùng, khi nào đó là lựa chọn đúng thì có thể gây tốn nhớ, lãng phí bộ nhớ nha!
vd: clone() đã mặc định chỉ cần supper.clone() cho primitive type hay immutable object rồi.  
Bạn không cần sợ không deep clone mà bản chất mọi sự thay đổi sẽ dẫn đến một object mới.

