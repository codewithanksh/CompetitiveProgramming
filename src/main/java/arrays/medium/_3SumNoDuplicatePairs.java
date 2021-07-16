package arrays.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3SumNoDuplicatePairs {

    public List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, Integer> map = null;
        List<Integer> res = new ArrayList();
        List<List<Integer>> finalList = new ArrayList();

        if (nums.length < 3)
            return finalList;

        for (int i = 0; i <= nums.length - 3; i++) {

            map = new HashMap<Integer, Integer>();

            for (int j = i + 1; j < nums.length; j++) {

                if (map.containsKey(-(nums[i] + nums[j]))) {

                    res = new ArrayList();
                    res.add(nums[i]);
                    res.add(-(nums[i] + nums[j]));
                    res.add(nums[j]);

                    boolean flag = true;
                    for (List<Integer> list : finalList) {

                        if (nums[i] == nums[j] && nums[j] == 0){
                            if(list.get(0) == 0 && list.get(1) ==0) {
                                flag = false;
                                break;
                            }
                        }
                        else if (list.contains(nums[i]) &&
                                list.contains(nums[j]) && list.contains(-(nums[i] + nums[j]))) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) finalList.add(res);

                }

                map.put(nums[j], j);
            }
        }

        return finalList;

    }

    @Test
    public void tc1() {
        int[] input = {-1, 0, 1, 2, -1, -4};
        threeSum(input);
    }

}
