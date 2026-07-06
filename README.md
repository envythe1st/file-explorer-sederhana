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

# Struktur Project

file-explorer/
