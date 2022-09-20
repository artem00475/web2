package data;

public final class Data {
    private final float x;
    private final  float y;
    private final float r;
    private final boolean hit;

    public Data(float x, float y, float r, boolean hit) {
        this.x=x;
        this.y=y;
        this.r=r;
        this.hit=hit;
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getR() {
        return r;
    }
    public boolean getHit() {
        return hit;
    }
}
