package september2025;

class LFoodRatings {
    String[] foods;
    String[] cuisines;
    int[] ratings;


    public LFoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
    }

    public void changeRating(String food, int newRating) {
        for (int i = 0; i < foods.length; i++ ) {
            if ((foods[i]).equals(food)) {
                ratings[i] = newRating;
            }
        }
    }

    public String highestRated(String cuisine) {
        int max_ratings = -1;
        int highest_index = 0;

        for (int i = 0; i < foods.length; i++) {
            if (((cuisines[i]).equals(cuisine)) && (ratings[i] >= max_ratings)) {

                if ((ratings[i] == max_ratings) && (foods[highest_index].compareTo(foods[i]) < 0)) {
                    continue;
                }
                max_ratings = ratings[i];
                highest_index = i;
            }
        }

        return foods[highest_index];
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */