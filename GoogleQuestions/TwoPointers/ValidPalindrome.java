public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;

    while (left < right) {
        // skip non-alphanumeric from the left
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }
        // skip non-alphanumeric from the right
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        }
        // compare, case-insensitive
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
