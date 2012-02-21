package com.aniXification.android.lovemeter;

import java.util.ArrayList;
import java.util.List;

public class LoveCalulator {
	
	/*
	 * Calculate Love
	 */
	public String calculateLove(String name){
		if(name !=null){
			List<String> alphaCountList = new ArrayList<String>();
			
			name = name.replaceAll(" ", "");	//replace all spaces
			name = name.toLowerCase();	//convert all letters to Lowercase
			
			char[] cArray = name.toCharArray();	//convert string to CharArray
			
			List<String> calculatedString = new ArrayList<String>();	//list to store character that is already counted
			
			for(int a=0;a<cArray.length;a++)
			{
				int countOfChar=1;//count of this character
				
				//System.out.println("checking if already calculator--"+cArray[a]+"  in  "+calculatedString);
				if(calculatedString.contains(cArray[a] + ""))
				{
					//System.out.println("Already calculated");
					continue;
				}
				//System.out.println("Not calculated");
				
				for(int b=a+1;b<cArray.length;b++)
				{
					if(cArray[a]==cArray[b])//yes this character is repeated, so increase count
					{
						countOfChar++;
					}
				}
				calculatedString.add(cArray[a]+"");//storing into list to keep track that this character is counted
				alphaCountList.add(countOfChar+"");//finally adding total count of this character in this list
			}
			//System.out.println(alphaCountList);
			
			//now finally calculate
			
			alphaCountList=countNumericValueOfCharacter(alphaCountList);//performing first sum in number
			while(alphaCountList.size()>2)//calculate sum of number until it remains to 2 digit only
			{ 
				alphaCountList=countNumericValueOfCharacter(alphaCountList);
				alphaCountList=manipulateString(alphaCountList);//manipulate number if it return more than 9
			}
			
			//System.out.println(alphaCountList.get(0)+alphaCountList.get(1)+"%");//final result
			return (alphaCountList.get(0)+alphaCountList.get(1));
		}
		
		return null;
	}
	
	/*
	 * the following method would calculate the sum of the first and the last character, adds to the list 
	 * and returns
	 * */
	
	public List<String> countNumericValueOfCharacter(List<String> alphaCountList){
		List<String> newAlfaCountList = new ArrayList<String>();
		int length=alphaCountList.size();
		
		if(length%2==1)//if list have even number then decrease count by 1
		{
			length=length-1;
		}
		for(int a=0;a<length/2;a++)//this will actually getting first & last number & add it and insert into new List
		{
			String num1=alphaCountList.get(a);
			String num2=alphaCountList.get(alphaCountList.size()-1-a);
			int newNum=Integer.parseInt(num1)+Integer.parseInt(num2);
			newAlfaCountList.add(newNum+"");
		}
		if(alphaCountList.size()%2==1)//if list have even number then add the middle number to the end of the new list
		{
			length=length-1;
			length=length/2;
			newAlfaCountList.add(alphaCountList.get(length+1));
		}
		return newAlfaCountList;
	}
	
	/*
	 * following method will convert the double digit to single digit
	 * */
	
	public List<String> manipulateString(List<String> numList){
		List<String> finalList = new ArrayList<String>();
		String allNumbers ="";
		for(String str:numList)
		{
			allNumbers=allNumbers+str;
		}
		
		char[] cArray = allNumbers.toCharArray();
		for(int a=0;a<cArray.length;a++)
		{
			finalList.add(cArray[a]+"");
		}
		return finalList;
	}

}
