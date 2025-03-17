// https://leetcode.com/problems/product-of-the-last-k-numbers/description/?envType=daily-question&envId=2025-02-14
// these kind of dailies suck

class ProductOfNumbers {

    private List<Integer> pfx = new ArrayList<>();
    private int sz = 0;

    public ProductOfNumbers() {
        pfx.add(1);
        sz = 0;
    }
    
    public void add(int num) {
        if (num == 0) {
            pfx = new ArrayList<>();
            pfx.add(1);
            sz = 0;
        } else {
            pfx.add(pfx.get(sz) * num);
            sz++;
        }
    }
    
    public int getProduct(int k) {
        if (k > sz) return 0;
        return pfx.get(sz) / pfx.get(sz - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */