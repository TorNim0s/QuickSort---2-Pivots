package Ex1;

import java.util.Arrays;

public class Ex1 {

	public static void QuickSort(int arr[]) {
		QuickSort(arr, 0, arr.length-1);
	}
	
	public static void QuickSort(int arr[], int start, int end) {
		if (start<=end) {
			int pivots[] = partition(arr,start,end);
			
			QuickSort(arr, start, pivots[0]-1);
			QuickSort(arr, pivots[0]+1, pivots[1]-1);
			QuickSort(arr, pivots[1]+1, end);
		}
	}

public static int[] partition(int arr[], int start, int end) {
		if (arr[start] > arr[end]) {
			int hold = arr[end];
			arr[end] = arr[start];
			arr[start] = hold;
		}
		
		int i1 = end - 1;
		int i2 = end - 1;
		int j = start + 1;
		int pivot1 = arr[start];
		int pivot2 = arr[end];
		
		while(i2>=j) {
			if(arr[i2] > pivot2) { 
				int hold = arr[i2];
				arr[i2] = arr[i1];
				arr[i1] = hold;
				i1--;
			}
			
			else if(arr[i2] <= pivot1) { 
				while(arr[i2] < pivot1 && j < i2) {
					i2--;
				}
				
				int hold = arr[j];
				arr[j] = arr[i2];
				arr[i2] = hold;
				i2--;
				
				if(arr[i2] > pivot2) { 
					hold = arr[i2];
					arr[i2] = arr[i1];
					arr[i1] = hold;
					i1--;
				}
				
			}
			
			i2--;
			
		}	
		
		j--;
		i1++;		
		
		arr[start] = arr[j];
		arr[j] = pivot1;
		
		arr[end] = arr[i1];
		arr[i1] = pivot2;
		
		return new int[] {i1, j};
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,8,25,6,7,1,5,9,0,5,48,6};
		
		QuickSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}

}
