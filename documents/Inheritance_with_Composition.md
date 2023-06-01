# Inheritance with Composition  

## Tổng quan:

### Lập trình?  
- Đưa bài toán, dữ liệu ngoài thực tế vào máy tính bằng ngôn ngữ máy tính, cái máy tính có thể hiểu được dưới dạng 0 và 1.
- Đưa vào để máy tính giúp ta lưu trữ hay xử lý và giải quyết bài toán.
- Thông qua ngôn ngữ lập trình -> dòng lệnh -> máy tính thực thi : máy tính hiểu được phải làm gì.

### OOP  

Ban đầu, khi chương trình nhỏ và đơn giản, 1 class có thể làm tất cả, nắm tất cả thông tin.
=> Lập trình thủ tục (procedural programming)  

Khi chương trình thay đổi (Lớn lên với many requirements, những requirements này lại biến động theo thời gian với nhiều lý do nghiệp vụ của khách hàng)  
=> Add mới feature hay thay đổi tính năng trở thành nightmare  
= Khó khăn, tốn nhiều công sức
=> Chương trình khó maintain và mở rộng  

OOP ra đời để giải toán bài toán thích ứng với sự thay đổi  
Chia một class thành nhiều class,  
Với nhiều cách chia tùy thuộc vào requirement   
mà tổng quát hóa bài toán hiện tại, trừu tượng hóa bài toán lên  (**Abstraction**)  
Để tách những phần chung ra  
=> reuse lại code với nhiều cách trong đó có **inheritance** / composition
=> Và tận dụng được tính đa hình (**polymophism**)  
Một method có nhiều cách hành xử khác nhau tùy thuộc class đang sử dụng là gì 

Để bài toán hiện tại đơn giản hơn,  
OOP cung cấp **encapsulate** => che lại những phần xử lý phức tạp   
Giữ bài toán đơn giản hơn  
=> Dễ nắm bắt hơn  
=> làm lập trình ~ dọn phòng, sắp xếp lại phòng.
### Inheritance và composition

OOP với nhiều cách hiện thực khác nhau ta có các design pattern khác nhau.

Và ở đây mình đang xét đến 2 cách reuse code là inheritance và composition  

Điểm chung, cả 2 đều cung cấp cho ta cách để reuse code chung và có tính flexible để đáp ứng được sự thay đổi.  


#### Composition:
has-a  

#### Inheritance
is-a  

#### So sánh

| Inheritance                                                                                               | Composition                                                                                       |
|-----------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| **Đơn giản hơn**, bạn chỉ cần extend từ class cha                                                         | Bạn chứa một phần chung và phải expose giống như class bạn chứa                                   |
| **Làm ít hơn**, method kế thừa từ cha, nếu đủ rồi không cần extend lại làm gì, dư thừa có thể dẫn đến lỗi | Gọi thành phần thêm vào làm cho = deleget, mặc dù đơn giản nhưng code có thể bị lặp với logic này |
| **Không rõ ràng bằng**, vì kế thừa                                                                        | Nằm ngay trong class hiện thực                                                                    |
| **Không flexible bằng,** chỉ có 1 class cha                                                               | Đổi object hiện thực của composition ầm ầm                                                        |    

Cả hai đều là cách reuse -> flexible -> đáp ứng thay đổi  
SOLID -> O: Open-Closed Principle requires that classes should be open for extension and closed to modification.

Note:  
Composition có 1 khái niệm là wrapper.  
VD: bạn có 1 class InstrumentedSet implement Set interface và trong constructor của InstrumentedSet chứa 1 attribute Set.  
InstrumentedSet is **wrapper** và **wraps** another Set instance.  
If wrapper chuyển phần xử lý của wrapped class cho wrapped instance (Set instance) thì đó là delegate. 
Wrapper thì trông giống Decorator pattern.  
![Decorator pattern](images/decorator%20pattern.png)  

Kết luận:
Với hai cách reuse inheritance và composition, mình thấy:
- Inheritance dễ dùng hơn vì bạn có thể kế thừa nhiều phương thức từ class cha mà không cần hiện thực lại
- Composition linh hoạt hơn vì bạn không bị giới hạn có một loại vì đơn kế thừa.

Interface -> Trường tượng hóa, tổng quát hóa -> hành động  
Attributes ~~ properties là implement.

Hình minh họa  
![inheritance - composition communication](images/inheritance%20composition%20communication.png)

Ví dụ:
https://github.com/hazoe-dev/samples_effective_java/tree/compare_inheritance_composition/src/main/java/shape_tool