public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];

    // Pass 1: res[i] = product of everything to the LEFT of i
    res[0] = 1;
    for (int i = 1; i < n; i++) {
        res[i] = res[i - 1] * nums[i - 1];
    }

    // Pass 2: multiply in product of everything to the RIGHT
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        res[i] = res[i] * right;
        right = right * nums[i];
    }

    return res;
}
