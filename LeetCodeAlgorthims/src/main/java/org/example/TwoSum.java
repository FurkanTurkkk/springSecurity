package org.example;

public class TwoSum {
    public static void main(String[] args) {
        int[] numbers={1,2,3,4,5,6};
        int goal=10;
        int[] goalArray=twoSum(numbers,goal);
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] answer=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==j){
                    continue;
                }
                int x=nums[i]+nums[j];
                if(x==target){
                    answer[0]=j;
                    answer[1]=i;
                    break;
                }
            }
        }
        return answer;
    }
}
