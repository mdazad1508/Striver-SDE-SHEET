// somewhat less than o(n^2)

/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
    
    for(let i=0;i<nums.length;i++){
       const elem = nums[i];
        for(let j=0;j<i;j++){
            if(nums[j]==elem) return nums[j];
        }
    }

    return -1;
};