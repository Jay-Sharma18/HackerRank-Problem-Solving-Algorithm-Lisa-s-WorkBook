package JavaAlgorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LisasWorkBook {
	


	    // Complete the workbook function below.
	    static int workbook(int n, int k, int[] arr) {
	        
	        //variable to hold current Page number as we move through page by page.
	        //This variable will be used for comparison with question number to find special         //questions
	        int currentPage=0;
	        //variable to hold count of special questions
	        int count=0;
	        //run the loop for each chapter
	        for(int i=0;i<n;i++)
	        {   
	            //if questions in a chapter are less than or equal to questions allowed on a 
	            //page, increment page number and run a loop from 1 to questions in the                  //chapter and icrement counter when a special question is encountered
	            if(arr[i]<=k)
	            {
	                currentPage++;
	                for(int j=1;j<=arr[i];j++)
	                {
	                    if(j==currentPage)
	                    {
	                        count++;
	                    }
	                }
	            }
	            //if questions in a chapter are greater than questions allowed on a page,
	            //increment current page each time the number of questions in the chapter                //exceeds questions allowed on the page and check for special questions. Do              //not increment current page if the last question falls on it
	            else
	            {   
	                currentPage+=1;
	                int temp=0;
	                for(int j=1;j<=arr[i];j++)
	                {   
	                    temp++;
	                    if(j==currentPage) count++;
	                    if(temp==k && j!=arr[i])
	                    {
	                        currentPage+=1;
	                        temp=0;
	                    }

	                }
	            }
	        }        
	        
	        
	       return count;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Jay\\Desktop\\Selenium,Drivers and Cucumber\\test.txt"));

	        String[] nk = scanner.nextLine().split(" ");

	        int n = Integer.parseInt(nk[0]);

	        int k = Integer.parseInt(nk[1]);

	        int[] arr = new int[n];

	        String[] arrItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int arrItem = Integer.parseInt(arrItems[i]);
	            arr[i] = arrItem;
	        }

	        int result = workbook(n, k, arr);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }
	}



