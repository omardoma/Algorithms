package main

import (
	"fmt"
	"strconv"
	"time"
)

func elapsed(what string) func() {
	start := time.Now()
	return func() {
		fmt.Printf("%s took %v\n", what, time.Since(start))
	}
}

func reverseString(str string) (revStr string) {
	length := len(str) - 1
	reverse := ""
	for i := range str {
		reverse += string(str[length-i])
	}
	return reverse
}

func isPalindrome(str string) bool {
	length := len(str) - 1
	for i := 0; i < length/2; i++ {
		if string(str[i]) != string(str[length-i]) {
			return false
		}
	}
	return true
}

func linearSearch(key int, arr []int) int {
	for i, current := range arr {
		if current == key {
			return i
		}
	}
	return -1
}

func binarySearch(key int, arr []int) int {
	var min, max, mid = 0, len(arr), 0
	for max >= min {
		mid = (max + min) / 2
		if arr[mid] == key {
			return mid
		}
		if arr[mid] < key {
			min = mid + 1
		} else {
			max = mid - 1
		}
	}
	return -1
}

func bubbleSort(arr []int) {
	var tmp int
	length := len(arr)
	for i := 0; i < length; i++ {
		for j := i; j < length-i-1; j++ {
			if arr[j+1] < arr[j] {
				tmp = arr[j+1]
				arr[j+1] = arr[j]
				arr[j] = tmp
			}
			fmt.Println("Iteration "+strconv.Itoa(i), arr)
		}
	}
}

func selectionSort(arr []int) {
	var tmp, min int
	length := len(arr)
	for i := 0; i < length-1; i++ {
		min = i
		for j := i + 1; j < length; j++ {
			if arr[j] < arr[min] {
				min = j
			}
		}
		if min != i {
			tmp = arr[i]
			arr[i] = arr[min]
			arr[min] = tmp
		}
		fmt.Println("Iteration "+strconv.Itoa(i), arr)
	}
}

func doubleSelectionSort(arr []int) {
	var min, max, oldMax, tmp int
	length := len(arr)
	for i := 0; i < length/2; i++ {
		min = i
		oldMax = length - i - 1
		max = oldMax
		for j := i + 1; j < length; j++ {
			if arr[j] < arr[min] {
				min = j
			}
			if arr[length-j] > arr[max] && (min != max) {
				max = length - j
			}
		}
		if min != i {
			tmp = arr[i]
			arr[i] = arr[min]
			arr[min] = tmp
		}
		if max != oldMax {
			tmp = arr[oldMax]
			arr[oldMax] = arr[max]
			arr[max] = tmp
		}
		fmt.Println("Iteration "+strconv.Itoa(i), arr)
	}
}

func insertionSort(arr []int) {
	var tmp int
	length := len(arr)
	for i := 1; i < length; i++ {
		for j := i; j > 0; j-- {
			if arr[j] < arr[j-1] {
				tmp = arr[j]
				arr[j] = arr[j-1]
				arr[j-1] = tmp
			}
		}
		fmt.Println("Iteration "+strconv.Itoa(i), arr)
	}
}

func main() {
	var arr []int
	var str string
	var benchmark func()

	arr = []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}
	fmt.Println("Sorted Array:", arr)
	fmt.Println("\nBinary Search")
	benchmark = elapsed("Binary Search")
	fmt.Println("Key Index: ", binarySearch(10, arr))
	benchmark()
	fmt.Println()

	arr = []int{3, 1, 4, 2, 6, 5, 8, 7, 10, 9}
	fmt.Println("Array:", arr)
	fmt.Println("\nLinear Search")
	benchmark = elapsed("Linear Search")
	fmt.Println("Key Index: ", linearSearch(6, arr))
	benchmark()

	fmt.Println("\nBubble Sort")
	benchmark = elapsed("Bubble Sort")
	bubbleSort(arr)
	fmt.Println(arr)
	benchmark()

	arr = []int{3, 1, 4, 2, 6, 5, 8, 7, 10, 9}
	fmt.Println("\nSelection Sort")
	benchmark = elapsed("Selection Sort")
	selectionSort(arr)
	fmt.Println(arr)
	benchmark()

	arr = []int{3, 1, 4, 2, 6, 5, 8, 7, 10, 9}
	fmt.Println("\nDouble Selection Sort")
	benchmark = elapsed("Double Selection Sort")
	doubleSelectionSort(arr)
	fmt.Println(arr)
	benchmark()

	arr = []int{3, 1, 4, 2, 6, 5, 8, 7, 10, 9}
	fmt.Println("\nInsertion Sort")
	benchmark = elapsed("Insertion Sort")
	insertionSort(arr)
	fmt.Println(arr)
	benchmark()

	str = "Omar loves Tuffy so much"
	fmt.Println("\nReverse String")
	benchmark = elapsed("Reverse String")
	fmt.Println(reverseString(str))
	benchmark()

	str = "ANBBNA"
	fmt.Println("\nPalindrome String")
	benchmark = elapsed("Palindrome String")
	fmt.Println(str+": ", isPalindrome(str))
	benchmark()
}
