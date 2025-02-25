#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends


class Solution:
    def getMaxArea(self,arr):
        #code here
        n = len(arr)
        right = [n]*n
        
        stack = []
        for i, e in enumerate(arr):
            while stack and arr[stack[-1]] > e:
                right[stack.pop()] = i
            stack.append(i)
        
        #print(right)
        stack = []
        left = [-1]*n
        for i in range(len(arr)-1, -1, -1):
            while stack and arr[stack[-1]] > arr[i]:
                left[stack.pop()] = i
            stack.append(i)
        
        #print(left)
        ans = 0
        for i in range(n):
            w = right[i]-left[i] - 1
            ans = max(ans, arr[i]*w)
        return ans


#{ 
 # Driver Code Starts.
#Initial Template for Python 3

if __name__ == "__main__":
    t = int(input())
    while t > 0:
        arr = list(map(int, input().split()))
        ob = Solution()
        res = ob.getMaxArea(arr)
        print(res)
        print("~")
        t -= 1


# } Driver Code Ends