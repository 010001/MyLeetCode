/**
 * @author fangbin
 * @date 19-3-12
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 */
public class LeetCode002 {
    /*public List<Integer>  addTwoNumbers(List<Integer> list01, List<Integer> list02) {
        List<Integer> result = new LinkedList<>();
        int list01Num = list01.size();
        int list02Num = list02.size();
        if(list01Num > list02Num){
            if(list02Num == 0){
                result.containsAll(list01);
            } else {

            }
        } else if(list01Num == list02Num){
            Iterator list01Iterator = list01.iterator();
            Iterator list02Iterator = list02.iterator();
            int localNum = 0;
            while(list01Iterator.hasNext()&& list02Iterator.hasNext()){
                int list01NumLocal = Integer.valueOf(String.valueOf(list01Iterator.next())).intValue();
                int list02NumLocal = Integer.valueOf(String.valueOf(list02Iterator.next())).intValue();
                if( list01NumLocal + list02NumLocal + localNum >= 10){
                    result.add( list01NumLocal + list02NumLocal + localNum -10);
                    localNum = 1;

                } else {
                    result.add( list01NumLocal + list02NumLocal + localNum );
                    localNum = 0;
                }
            }
        } else {
            if(list01Num == 0){
                result.containsAll(list02);
            }
        }

        return result;
    }

  public static void main(String[] args) {
      List<Integer> list01 = new LinkedList<Integer>();
      List<Integer> list02 = new LinkedList<Integer>();
      list01.add(2);
      list01.add(4);
      list01.add(3);
      list02.add(5);
      list02.add(6);
      list02.add(4);
    System.out.println(new LeetCode002().addTwoNumbers(list01,list02));
  }*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode returnNode = null;
        ListNode p = l1;
        ListNode q = l2;
        if(null != p && null != q){
            returnNode = new ListNode(0);
        }
        ListNode key = returnNode;

        while (null != p || null != q){
            if(null != p && null != q){
                if(p.val + q.val + key.val >= 10){
                    key.val = p.val + q.val + key.val -10;
                    key.next = new ListNode(1);
                } else {
                    key.val = p.val + q.val + key.val;
                    if(null != p.next || null != q.next ){
                        key.next = new ListNode(0);
                    }
                }
                p = p.next;
                q = q.next;
                key = key.next;
            } else {
                if(null != p){
                    ListNode result = this.addTwoNumbers(key,p);
                    key.val = result.val;
                    key.next = result.next;
                    p = null;
                } else {
                    ListNode result = this.addTwoNumbers(key,q);
                    key.val = result.val;
                    key.next = result.next;
                    q = null;
                }
            }
        }

        return returnNode;
    }

  public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        /*l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);*/
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        //l2.next.next = new ListNode(4);

      ListNode returnNode = new LeetCode002().addTwoNumbers(l1,l2);
      ListNode key = returnNode;
      while(null != key ){
        System.out.println(key.val);
        key = key.next;
      }


  }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
