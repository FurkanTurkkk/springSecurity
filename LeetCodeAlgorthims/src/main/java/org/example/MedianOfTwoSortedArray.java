package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] x={1,3};
        int[] y={2};
        System.out.println(findMedianSortedArrays(x,y));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m=nums1.length, n=nums2.length;

        List<Integer> list=new ArrayList<>();
        for(int num : nums1){
            list.add(num);
        }
        for(int num:nums2){
            list.add(num);
        }
        Collections.sort(list);
        if((list.size())%2==0){
            int mid=list.size()/2;
            return (double) (list.get(mid) + list.get(mid - 1)) /2;
        }
        else{
            return (double) list.get((list.size()/2));
        }

    }
}
