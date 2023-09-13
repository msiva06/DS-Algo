package TwoPointers;

// Sort Colors in place
public class Problem_04 {
    public static int[] sortColors (int[] colors) {

        int white = 0, red = 0, blue = colors.length-1;
        while(white <= blue){
            if(colors[white] == 0){
                if(colors[red] != 0){
                    int temp = colors[red];
                    colors[red] = colors[white];
                    colors[white] = temp;
                }
                red++;
                white++;
            }
            else if(colors[white] == 1)
            {
                white++;
            }
            else{
                if(colors[blue] != 2){
                    int temp = colors[blue];
                    colors[blue] = colors[white];
                    colors[white] = temp;
                }
                blue--;
            }
        }
        return colors;
    }
}
