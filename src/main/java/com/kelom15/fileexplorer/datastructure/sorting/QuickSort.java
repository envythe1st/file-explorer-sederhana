package com.kelom15.fileexplorer.datastructure.sorting;

import java.time.Instant;
import java.util.List;

import com.kelom15.fileexplorer.dto.DirectoryResponse;

public class QuickSort {

    public static void sortByName(List<DirectoryResponse> list) {

        if (list == null || list.size() <= 1) {
            return;
        }

        quickSortName(list, 0, list.size() - 1);

    }

    private static void quickSortName(
            List<DirectoryResponse> list,
            int low,
            int high) {

        if (low < high) {

            int pi = partitionName(list, low, high);

            quickSortName(list, low, pi - 1);

            quickSortName(list, pi + 1, high);

        }

    }

    private static int partitionName(
            List<DirectoryResponse> list,
            int low,
            int high) {

        String pivot = list.get(high).getName().toLowerCase();

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (list.get(j).getName().toLowerCase()
                    .compareTo(pivot) <= 0) {

                i++;

                swap(list, i, j);

            }

        }

        swap(list, i + 1, high);

        return i + 1;

    }

    public static void sortByNameDesc(List<DirectoryResponse> list) {

        sortByName(list);

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            DirectoryResponse temp = list.get(left);

            list.set(left, list.get(right));

            list.set(right, temp);

            left++;
            right--;

        }

    }

    public static void sortBySize(List<DirectoryResponse> list) {

        if (list == null || list.size() <= 1) {
            return;
        }

        quickSortSize(list, 0, list.size() - 1);

    }

    private static void quickSortSize(
            List<DirectoryResponse> list,
            int low,
            int high) {

        if (low < high) {

            int pi = partitionSize(list, low, high);

            quickSortSize(list, low, pi - 1);

            quickSortSize(list, pi + 1, high);

        }

    }

    private static int partitionSize(
            List<DirectoryResponse> list,
            int low,
            int high) {

        long pivot = list.get(high).getSize();

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (list.get(j).getSize() >= pivot) {

                i++;

                swap(list, i, j);

            }

        }

        swap(list, i + 1, high);

        return i + 1;

    }

    public static void sortByDate(List<DirectoryResponse> list) {

        if (list == null || list.size() <= 1) {
            return;
        }

        quickSortDate(list, 0, list.size() - 1);

    }

    private static void quickSortDate(
            List<DirectoryResponse> list,
            int low,
            int high) {

        if (low < high) {

            int pi = partitionDate(list, low, high);

            quickSortDate(list, low, pi - 1);

            quickSortDate(list, pi + 1, high);

        }

    }

    private static int partitionDate(
            List<DirectoryResponse> list,
            int low,
            int high) {

        Instant pivot = Instant.parse(
                list.get(high).getLastModified());

        int i = low - 1;

        for (int j = low; j < high; j++) {

            Instant current = Instant.parse(
                    list.get(j).getLastModified());

            if (current.compareTo(pivot) >= 0) {

                i++;

                swap(list, i, j);

            }

        }

        swap(list, i + 1, high);

        return i + 1;

    }

    public static void sortFolderFirst(List<DirectoryResponse> list) {

        if (list == null || list.size() <= 1) {
            return;
        }

        quickSortFolder(list, 0, list.size() - 1);

    }

    private static void quickSortFolder(
            List<DirectoryResponse> list,
            int low,
            int high) {

        if (low < high) {

            int pi = partitionFolder(list, low, high);

            quickSortFolder(list, low, pi - 1);

            quickSortFolder(list, pi + 1, high);

        }

    }

    private static int partitionFolder(
            List<DirectoryResponse> list,
            int low,
            int high) {

        boolean pivot = list.get(high).isDirectory();

        int i = low - 1;

        for (int j = low; j < high; j++) {

            boolean current = list.get(j).isDirectory();

            if (current == pivot || current) {

                i++;

                swap(list, i, j);

            }

        }

        swap(list, i + 1, high);

        return i + 1;

    }

    private static void swap(
            List<DirectoryResponse> list,
            int i,
            int j) {

        DirectoryResponse temp = list.get(i);

        list.set(i, list.get(j));

        list.set(j, temp);

    }

}
