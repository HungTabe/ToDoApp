# TodoListApp

## Giới thiệu

**TodoListApp** là một ứng dụng Android đơn giản được phát triển bằng Java trên Android Studio. Ứng dụng này cho phép người dùng quản lý danh sách công việc hàng ngày, bao gồm thêm công việc mới, đánh dấu công việc đã hoàn thành, và xóa tất cả công việc. Dữ liệu được lưu trữ bằng `SharedPreferences` để đảm bảo danh sách công việc không bị mất khi thoát ứng dụng.

Dự án được thiết kế để thực hành các kỹ năng cơ bản trong lập trình Android, bao gồm:
- **Binding views**: Liên kết các thành phần giao diện như `EditText`, `Button`, và `ListView`.
- **Handling actions**: Xử lý các hành động như thêm hoặc xóa công việc.
- **Common event listeners**: Sử dụng `OnClickListener` và `OnItemClickListener` để tương tác với người dùng.

## Tính năng

- Thêm công việc mới thông qua `EditText` và nút "Thêm".
- Đánh dấu công việc đã hoàn thành bằng `CheckBox` hoặc nhấn vào item trong `ListView`.
- Xóa tất cả công việc bằng nút "Xóa tất cả".
- Lưu trữ danh sách công việc bằng `SharedPreferences` để dữ liệu được lưu giữa các phiên sử dụng.
- Giao diện đơn giản và dễ sử dụng.

## Yêu cầu

- **Android Studio**: Phiên bản Arctic Fox (2020.3.1) trở lên.
- **JDK**: Java 11 hoặc cao hơn.
- **Minimum API**: API 21 (Android 5.0 Lollipop).
- **Thiết bị**: Thiết bị Android hoặc trình giả lập.

## Cài đặt

1. **Tải mã nguồn**:
   - Clone repository hoặc tải mã nguồn về máy:
     ```bash
     git clone <repository-url>
     ```

2. **Mở dự án**:
   - Mở Android Studio.
   - Chọn **File > Open** và chọn thư mục dự án `TodoListApp`.

3. **Cấu hình Gradle**:
   - Đảm bảo file `build.gradle` (Module: app) có các dependency sau:
     ```gradle
     dependencies {
         implementation 'androidx.appcompat:appcompat:1.6.1'
         implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
         implementation 'com.google.code.gson:gson:2.10.1'
     }
     ```
   - Nhấn **Sync Project with Gradle Files** để tải các dependency.

4. **Chạy ứng dụng**:
   - Kết nối thiết bị Android hoặc khởi động trình giả lập.
   - Nhấn **Run** (`Shift + F10`) để chạy ứng dụng.

## Cách sử dụng

1. **Thêm công việc**:
   - Nhập tên công việc vào ô `EditText`.
   - Nhấn nút **Thêm** để thêm công việc vào danh sách.

2. **Đánh dấu hoàn thành**:
   - Nhấn vào một công việc trong `ListView` hoặc tích vào `CheckBox` để đánh dấu công việc đã hoàn thành.

3. **Xóa tất cả công việc**:
   - Nhấn nút **Xóa tất cả** để xóa toàn bộ danh sách công việc.

4. **Lưu trữ dữ liệu**:
   - Danh sách công việc sẽ tự động được lưu và tải lại khi bạn mở ứng dụng.

## Cấu trúc dự án

- **`app/src/main/java/com/example/todolistapp`**:
  - `MainActivity.java`: Xử lý logic chính của ứng dụng.
  - `Task.java`: Lớp mô hình để lưu thông tin công việc (tên và trạng thái hoàn thành).
  - `TaskAdapter.java`: Adapter để hiển thị danh sách công việc trong `ListView`.
- **`app/src/main/res/layout`**:
  - `activity_main.xml`: Giao diện chính của ứng dụng.
  - `task_item.xml`: Giao diện cho mỗi item trong `ListView`.
- **`app/src/main/AndroidManifest.xml`**: Cấu hình ứng dụng.

## Công nghệ sử dụng

- **Ngôn ngữ**: Java.
- **Giao diện**: XML với `ConstraintLayout`, `ListView`.
- **Lưu trữ**: `SharedPreferences` với `Gson` để lưu danh sách công việc dưới dạng JSON.
- **Thư viện**: 
  - AndroidX (AppCompat, ConstraintLayout).
  - Gson (cho xử lý JSON).

## Hướng dẫn phát triển thêm

- **Sử dụng RecyclerView**: Thay `ListView` bằng `RecyclerView` để có giao diện linh hoạt hơn.
- **Cơ sở dữ liệu SQLite**: Lưu trữ công việc trong SQLite thay vì `SharedPreferences`.
- **Xóa từng công việc**: Thêm nút "Xóa" cho mỗi item trong danh sách.
- **Giao diện Material Design**: Áp dụng `CardView`, màu sắc, và hiệu ứng để cải thiện giao diện.
- **Thông báo**: Thêm thông báo nhắc nhở cho các công việc chưa hoàn thành.

## Góp ý và báo lỗi

Nếu bạn gặp lỗi hoặc có ý tưởng cải thiện, vui lòng:
- Mở một **Issue** trên GitHub.
- Gửi email đến trandinhhung717@gmail.com.

## Giấy phép

Dự án này được phát hành dưới [MIT License](LICENSE).

---

**Tác giả**: TranDinhHung  
**Ngày tạo**: 19/05/2025