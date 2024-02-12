package christmas.domain.constant;

public enum Badge{
    NONE("없음"), STAR("별"), TREE("트리"), SANTA("산타");

    private final String desc;

    Badge(String desc){
        this.desc = desc;
    }
    public static Badge of(int discount){
        if(discount < 5000){
            return NONE;
        }
        if(discount < 10000){
            return STAR;
        }
        if(discount < 20000){
            return TREE;
        }
        return SANTA;
    }
}
