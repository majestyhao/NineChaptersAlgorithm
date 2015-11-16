package BinarySearch;


public class FindFirstBadVersion {
	public class versionControl {
		public boolean isBadVersion(int k) {
			return k > 3;
		}
	}
	
	private versionControl VersionControl = new versionControl();

	/**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
    	if (n < 0) {
    		return -1;
    	}
    	int start = 1, end = n;
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (VersionControl.isBadVersion(mid)) {
    			end = mid;
    		} else {
    			start = mid;
    		}
    	}
    	
    	if (VersionControl.isBadVersion(start)) {
    		return start;
    	}
    	if (VersionControl.isBadVersion(end)) {
    		return end;
    	}
    	return -1;
    }

}
