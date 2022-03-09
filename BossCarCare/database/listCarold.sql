insert into Cars(name,info,img,price,[current],color,categoryid) values
('Morning','4 cho','https://bitly.com.vn/siixgu',
300000,'0','white',8),
('I10','4 cho','https://bitly.com.vn/cloccw',
400000,'0','white',6),
('City','4 cho sendan','http://icdn.dantri.com.vn/zoom/1200_630/2020/12/10/hondacity-2020-dauxe-1607553580639.jpg',
500000,'0','red',1),
('Rio','4 cho sendan','https://katavina.com/uploaded/tin-tuc/kia-rio-2021-1.jpg',
500000,'0','blue',8),
('K3','4 cho sendan','https://www.carscoops.com/wp-content/uploads/2019/04/c55861e4-2020-kia-k3-phev-china-0.jpg',
400000,'0','red',8),
('Mazda 3','4 cho sendan','https://mazdamiennam.com/wp-content/uploads/2019/11/dau-mazda-3-2020-600x450.jpg',
400000,'0','red',9),
('Mazda 6','4 cho sendan','https://bitly.com.vn/txi7g7',
800000,'0','black',9),
('Civic','4 cho sendan','http://cms-i.autodaily.vn/du-lieu/2018/10/18/rg-geneva-2017-honda-civic-type-r-1-1600.jpg',
900000,'0','red',1),
('Rondo AT','7 cho','https://img1.oto.com.vn/2021/08/23/OpzfnMD2/rondo-2821.jpg',
600000,'0','white',8),
('Rondo AT','7 cho','https://tuvanmuaxe.vn/upload/upload_img/images/chi-tiet-toyota-innova-2018-MT-tuvanmuaxe-13.jpg',
800000,'0','gray',2),

insert into Categories values
('Mazda')
select * from Categories
select c.name,info,img,price,[CURRENT],color,cc.name as[cateName]
from Cars c left join Categories cc 
on categoryid = cc.id 

update Cars set img = 'https://i.xeoto.com.vn/auto/w900/kia/morning/2021/mau-xe-kia-morning-trang.png' where id = 1