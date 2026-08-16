/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    private int findPeak(MountainArray mountainArr) {
        int low = 0;
        int high = mountainArr.length() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int firstHalf(int target, MountainArray mountainArr, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int el = mountainArr.get(mid);
            if (el == target) {
                return mid;
            } else if (el < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int secondHalf(int target, MountainArray mountainArr, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int el = mountainArr.get(mid);
            if (el == target) {
                return mid;
            } else if (el < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeak(mountainArr);
        int firstHalf = firstHalf(target, mountainArr, 0, peakIndex);
        if (firstHalf != -1) {
            return firstHalf;
        }
        return secondHalf(target, mountainArr, peakIndex + 1, mountainArr.length() - 1);
    }
}