import random

Ho = ['Nguyễn', 'Trần', 'Võ', 'Huỳnh', 'Hoàng', 'Phạm', 'Hồ', 'Lê', 'Lý', 'Vương', 'Tống', 'Phan', 'Vũ', 'Ngô', 'Dương',
      'Đàm', 'Quách', 'Ong', 'Tô', 'Tôn', 'Đỗ', 'Thiều', 'Chế', 'Ninh', 'Mã', 'Hứa', 'Đậu', 'Kiều', 'Đinh']
Ten_nam = ['An', 'Anh', 'Ánh', 'Linh', 'Phương', 'Giang', 'Cường', 'Tùng', 'Thắng', 'Vinh', 'Đạt', 'Thành',
           'Cương', 'Vỹ', 'Trung', 'Quang', 'Thọ', 'Tuấn', 'Kiệt', 'Hậu', 'Toàn', 'Vĩnh', 'Phong', 'Phúc', 'Nghĩa',
           'Khánh', 'Nhật', 'Nhựt', 'Triều', 'Khoa', 'Khang', 'Minh', 'Hòa', 'Tiến']

Ten_nu = ['An', 'Anh', 'Ánh', 'Trang', 'Linh', 'Phương', 'Thảo', 'Hân', 'Vy', 'Hằng', 'Giang', 'Nhung', 'Yến',
          'Nga', 'Mai', 'Đào', 'Hoa', 'Thu', 'Hiến', 'Vân', 'Nguyên', 'Như', 'Chi', 'Hậu', 'Lam', 'Uyên',
          'Trúc', 'Quỳnh', 'Thư', 'Tuyền', 'Phượng', 'Thi']

TenDem = ['Thị', 'Nhã', '']

n = int(input('Số tên cần random: \n'))
print('len Ho: ', len(Ho))
for i in range(n):
    id_ho = random.randint(0, len(Ho) - 1)
    # id_ten = random.randint(0, len(Ten) - 1)
    # print(id_ho, id_ten)
    # HoVaTen = Ho[id_ho] + " " + Ten[id_ten]
# print(HoVaTen, id_ho, id_ten)
