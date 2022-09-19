package data;

public class Data {
    private float x;
    private float y;
    private float r;
    private boolean hit;

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
