package com.itxingrui;


public class MergeSort {
    public static void main(String[] args) {

        int[] arr = new int[] {1,3,4,2};
        System.out.println(smallSum(arr));
    }

    /**
     * 进行了简单的验证
     * @param arr
     * @return
     */
    static int smallSum(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int l, int r) {
        //又进行了验证
        if (l == r)
            return 0;

        int mid = l + ((r - l) >> 1); //求了个中间的索引

        return mergeSort(arr, l, mid) + // 左侧产生的小和
                mergeSort(arr, mid + 1, r) + // 右侧产生的小和
                merge(arr, l, mid, r); // merge过程中产生的小和
    }

    static int merge(int[] arr,int l,int m,int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
//        int res = 0;
        while(p1 <= m && p2 <= r) {
//            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m)
            help[i++] = arr[p1++];
        while(p2 <= r)
            help[i++] = arr[p2++];
        for(i = 0;i < help.length;i++)
            arr[i + l] = help[i];
//        return res;
    }
}