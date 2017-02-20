/**
 * Note ;5 ways to do a binary xor with booleans 
 * Assume x and y are the input booleans 
 * 
 * (x != y)
 * (!x && y) || (x && !y) 
 * !(x || !y) || !(!x || y) 
 * !(	!(!x && y) && !(x && !y)	)
 * !(	(x || !y) && (!x || y) 	)
 * 
 */
/**
 * @author kgurushankar773
 * @since
 */
package craps;