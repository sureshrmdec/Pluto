package com.jiaxin.company.fb.online;
/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=117371&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dcheckbox%26sortid%3D311
 * sparse vector dot product 
 * 
 * Follow up: what if the number of nonzero elements of one vector is 10^10 and the other is 10^2, how can you make it faster?.
 * A =[0,2,0,2,0,0,3,0,0,4] ==> A={(1,2), (3,2), (6,3), (9,4)}
 * B=[0,0,0,0,5,0,2,0,0,8]  ==> B={(4,5), (6,2), (9,8)}
 * 
 * for each index i,  a = val of pair (i, v_in_A), b= val of pair (i, v_in_B) 
 * dot_product(A,B) = sum_of ( a * b ) 
 * A dot product B = 3*2 + 4*8 = 38
 * 
 * save time to calculate 0 * non-element values
 * 
 * @author jiashan
 *
 */
public class DotProduct {

}
