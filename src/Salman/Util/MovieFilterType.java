package Salman.Util;

public enum MovieFilterType {
    cast,title,category;

    public static MovieFilterType getMovieFilterType(String type){
        switch(type){
            case "cast":
                return cast;
            case "title":
                return title;
            case "category":
                return category;
            default:
                throw new IllegalArgumentException("Movie Type Not Supported");
        }

    }

}
