# 📁 Sistem File Explorer Sederhana

## Deskripsi

Sistem File Explorer Sederhana merupakan aplikasi berbasis web yang digunakan untuk menampilkan struktur folder dan file yang terdapat pada komputer pengguna. Aplikasi ini dibangun sebagai implementasi konsep Struktur Data pada mata kuliah Struktur Data.

Berbeda dengan File Explorer bawaan sistem operasi, aplikasi ini berfokus pada penerapan struktur data secara manual, khususnya N-ary Tree sebagai representasi direktori, Stack sebagai riwayat navigasi, dan Queue sebagai proses traversal folder.

---

# Tujuan Proyek

Proyek ini dibuat untuk memenuhi tugas Ujian Akhir Semester (UAS) Mata Kuliah Struktur Data dengan tujuan:

- Mengimplementasikan struktur data ke dalam aplikasi nyata.
- Memahami cara kerja Tree dalam representasi direktori.
- Mengimplementasikan Stack dan Queue tanpa menggunakan library bawaan Java.
- Menganalisis kompleksitas algoritma (Big-O).
- Membangun aplikasi berbasis web menggunakan Java Spring Boot dan React.

---

# Fitur

- Membaca folder dari komputer pengguna
- Menampilkan struktur folder secara hierarki
- Menampilkan isi folder
- Menampilkan informasi file
- Navigasi antar folder
- Riwayat navigasi menggunakan Stack
- Traversal folder menggunakan Queue (Breadth First Search)
- REST API Backend
- Tampilan web menggunakan React

---

# Struktur Data yang Digunakan

## 1. N-ary Tree

Digunakan sebagai struktur utama untuk menyimpan hubungan folder dan file.

Implementasi:

- DirectoryTree
- DirectoryNode

Operasi:

- Membuat root
- Menambahkan child
- Traversal
- Menghitung jumlah node

Kompleksitas:

| Operasi        | Big O |
| -------------- | ----- |
| Insert Child   | O(1)  |
| Traversal Tree | O(n)  |
| Count Node     | O(n)  |

---

## 2. Stack

Digunakan untuk menyimpan riwayat navigasi folder.

Implementasi:

NavigationStack

Operasi:

- Push
- Pop
- Peek
- IsEmpty

Kompleksitas:

| Operasi | Big O |
| ------- | ----- |
| Push    | O(1)  |
| Pop     | O(1)  |
| Peek    | O(1)  |

---

## 3. Queue

Digunakan untuk algoritma Breadth First Search (BFS).

Implementasi:

BFSQueue

Operasi:

- Enqueue
- Dequeue
- Peek
- IsEmpty

Kompleksitas:

| Operasi | Big O |
| ------- | ----- |
| Enqueue | O(1)  |
| Dequeue | O(1)  |
| Peek    | O(1)  |

---

# Teknologi

## Backend

- Java 21
- Spring Boot
- Maven
- Java NIO

## Frontend

- React
- Vite
- Axios

## IDE

- IntelliJ IDEA
- Visual Studio Code

---

## Struktur Project

# Backend
file-explorer/src
│
├── controller
├── service
├── datastructure
│ ├── tree
│ ├── stack
│ └── queue
├── dto
└── config
│

# frontend

file-explorer/frontend
├── src
│ ├── components
│ ├── pages
│ ├── services
│ └── assets


---

# Cara Menjalankan

## Backend

Masuk ke folder project

1. Masuk ke project : cd file-explorer
2. Jalankan : mvn spring-boot:run
3. Backend berjalan pada : http://localhost:8080

---

## Frontend

1. Masuk ke folder Frontend : cd frontend
2. Jalankan : npm run dev
3. Frontend berjalan pada : http://localhost:5173


---

# Cara Penggunaan

## 1.

Jalankan Backend.

## 2.

Jalankan Frontend.

## 3.

Masukkan path folder yang ingin dibuka.

Contoh

C:\Users atau D:\Project


## 4.

Tekan tombol **Load** atau **Open**.

## 5.

Sistem akan:

- membaca folder
- membangun N-ary Tree
- mengirim data ke frontend
- menampilkan struktur folder

## 6.

Klik folder untuk melihat isi folder.

## 7.

Klik file untuk melihat informasi file.

---

# REST API

## Membuat Tree

GET /api/tree

contoh,
GET /api/tree?path=C:\Users

---

## Menampilkan Isi Folder

GET /api/list 
 
---

## Breadth First Search

GET /api/bfs 

---

# Analisis Kompleksitas

| Proses         | Kompleksitas |
| -------------- | ------------ |
| Build Tree     | O(n)         |
| Traversal Tree | O(n)         |
| BFS            | O(n)         |
| Stack Push     | O(1)         |
| Stack Pop      | O(1)         |
| Queue Enqueue  | O(1)         |
| Queue Dequeue  | O(1)         |

---

# Kelebihan

- Struktur data diimplementasikan sendiri.
- Menggunakan Tree sesuai representasi direktori.
- Mudah dikembangkan.
- Arsitektur backend dan frontend terpisah.
- REST API mudah diintegrasikan.

---

# Kekurangan

- Belum mendukung operasi copy, move, rename, dan delete file.
- Belum mendukung pencarian file secara langsung.
- Belum terdapat autentikasi pengguna.
- Belum mendukung multi-user.

---

# Pengembangan Selanjutnya

- Search File
- Sorting File
- Filter berdasarkan tipe file
- Breadcrumb Navigation
- Dark Mode
- Drag & Drop
- Upload File
- Delete File
- Rename File
- Copy dan Move File
- Monitoring perubahan folder secara real-time

---

# Anggota Kelompok

Kelompok 18

- Nama Anggota 1
- Nama Anggota 2
- Nama Anggota 3
- Nama Anggota 4

---

# Lisensi

Proyek ini dibuat untuk keperluan akademik pada Mata Kuliah Struktur Data.