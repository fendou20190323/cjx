public class ShadowClone implements Cloneable {
    private int a;   // 基本类型
    private int[] b; // 非基本类型    // 重写Object.clone()方法,并把protected改为public

    @Override
    public Object clone() {
        ShadowClone sc = null;
        try {
            sc = (ShadowClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sc;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int[] getB() {
        return b;
    }

    public void setB(int[] b) {
        this.b = b;
    }
}