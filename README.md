## Project Description
Pada project kali ini, terdapat aplikasi pemesanan menu di sebuah cafe, yakni bernama :

    Ody Cafe 

Didalamnya terdapat skenario dari kedua belah pihak, yakni Customer & Admin. yang dimana masing masing dari kedua pihak tersebut dapat melakukan berbagai mekanisme didalam aplikasi untuk melakukan beberapa fitur pengaplikasiannya, dan tentunya kesemua itu bertujuan untuk menunjang jalannya bisnis dari owner  atau pemilik usaha serta kemudahan dalam transaksi pembeli. 

Dalam aktivitas peranannya, disini Customer & Admin dapat melakukan beragam hal yang terkait dengan aktifitas dalam pemesanan di sebuah cafe, seperti halnya (Customer membuat pesanan -> Dapat melihat Pesanan, Dapat mengedit Pesanan & Menghapus Pesanan, serta Dapat tampil di berbagai halaman yang terkait), begitu juga sebaliknya, yakni Admin. 

Selain dari fungsionalitas utamanya yakni ‘CRUD’ terdapat juga beberapa fitur & fungsi lainnya, seperti halnya struktur dari db yang saya buat, yakni memakai skema roomdatabase / db lokal. serta memakai SQLite sebagai perangkat RDBMS penyimpanan data untuk memudahkan beragam perubahan data dari db tersebut.

Untuk Detail Project, seperti kesesuaian CRUD terhadap fungsionalitas Aplikasi, Pemetaan Pages, Use Case, dan lain sebagainya, akan saya cantumkan dibawah :

## Use Case
![odycafe](https://github.com/Aldayanday1/odycafe/assets/91641328/98f88f6b-0042-4c0e-8bca-333824cdedc3)


## Mekanisme CRUD 

    Admin 
1.	Create : Dapat Menambah Menu
2.	Read : Dapat Melihat Menu yang sudah didaftarkan sebelumnya (Halaman Menu)
3.	Update : Dapat melakukan Pembaruan Menu
4.	Delete : Dapat melakukan Penghapusan Menu

##

    Customer 
1.	Create : Dapat Menambah Pesanan
2.	Read : Dapat Melihat Pesanan yang sudah didaftarkan sebelumnya (Halaman Pesanan)
3.	Update : Dapat melakukan Pembaruan Pesanan
4.	Delete : Dapat melakukan Penghapusan Pesanan


## Fitur selain dari CRUD 

1.	Navigation : Pemetaan antar halaman, Pengguna bisa mengakses berbagai Halaman dengan saat mereka menekan button, baik itu button ‘Back’ dari Navbar, atau bahkan fungsi dari beberapa Button yang menjadi acuan saat setelah ditekan, yang dimana saat mereka menekannya, mereka akan berpindah ke halaman yang sudah dipetakan sebelumnya.

2.	Foreign key Relation : Relasi antar tabel yang menghubungkan kedua entitas, yakni entitas Menu sebagai (ParentColumns) dan Pesanan (ChildColumns), yang artinya salah satu column dari atribut pesanan itu mengambil data dari Menu yang sudah tersedia di entitas Menu. Serta dalam Praktiknya atau Contoh Kasus nya -> saya menggunakan properti “DropdownMenu” untuk pemetaan dari fungsi foreign key tersebut, jadinya customer tidak dapat memesan Menu jika Admin/Owner nya tidak menginputkan Menu di list menu sebelumnya. 

3.	Search : Dapat mencari daftar Menu dan Pesanan yang tersedia (dari apa yang sudah diinputkan sebelumnya) 

## Pemetaan Pages - Admin & Customer

1.	Halaman Start : Halaman Pertama saat Aplikasi di Running

2.	Halaman Admin : Pemetaan Navigasi yang merujuk ke (Halaman Menu & List Pesanan)
3.	Halaman Customer : Pemetaan Navigasi yang merujuk ke (Halaman Pesanan & List Menu)
4.	Halaman Menu : Sistematika CRUD yang diakses oleh Admin
5.	Halaman List Menu : (Read Only – yang hanya bisa diihat oleh Customer)
6.	Halaman Pesanan : Sistematika CRUD yang diakses oleh Customer
7.	Halaman List Pesanan : (Read Only - yang hanya bisa diihat oleh Admin)
8.	Halaman Detail Menu : Lanjutan Pemetaan Navigasi dari ‘Halaman Menu’
9.	Halaman Detail Pesanan : Lanjutan Pemetaan Navigasi dari ‘Halaman Pesanan’

## 

Bermula dari saat aplikasi di Running, ‘Halaman Start’ adalah halaman yang menjadi First Page atau Main page dalam keberlangsungannya aplikasi ini saat dijalankan, didalamnya yakni ‘Halaman Start’, terdapat kedua tombol yang mengarah ke bagian ‘Halaman Admin’ & ‘Halaman Customer’. Lalu kedua halaman tersebut juga diberikan pemetaan terhadap 2 tombol lagi dari masing-masing halamannya, yakni ‘Halaman Admin’ dapat mengakses terhadap ‘Halaman Menu’ & List Pesanan’ . serta ‘Halaman Customer’ dapat mengakses ‘Halaman Pesanan’ & ‘Halaman List Menu’.

Jadi, mekanisme secara singkat nya, ‘Halaman Admin’ ini adalah halaman yang sebetulnya hanya bisa diakses oleh Admin. Karena pemetaan nya mengarah ke ‘Halaman Menu’ yang dimana Admin/Owner dapat membuat Menu, melihat Menu / Mekanisme CRUD lainnya didalamnya, serta selain dari ‘Halaman Menu’, terdapat juga ‘Halaman List Pesanan’, yakni keseluruhan hasil pesanan yang dibuat oleh ‘Customer’ dapat dilihat langsung oleh ‘Admin'. (Read Only, Search), jadi Admin dapat melihat mana saja list Pesanan yang sudah didaftarkan oleh Customer sebelumnya, tanpa bisa mengedit dan menghapusnya.

Selain itu terdapat ‘Halaman Detail’ dari lanjutan di kedua Halaman ‘Menu’ & ‘Pesanan’ yang menjadi tolak ukur pemetaan Halaman untuk Admin & Customer agar dapat melakukan pembaruannya seperti Fitur ‘Edit’ & ‘Delete’.
