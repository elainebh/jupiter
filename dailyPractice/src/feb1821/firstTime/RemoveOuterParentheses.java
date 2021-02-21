package feb1821.firstTime;
// 1021. Remove Outermost Parentheses
// first try completed on 2/18/21; need to review and continue the second and third time.
class RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {
        int openBrackets = 0;
        StringBuilder sb = new StringBuilder();
        char[] sChar = S.toCharArray();

        for (int i = 0; i < sChar.length; i++) {
            char currChar = sChar[i];

            //Outer Bracket Start
            if (currChar == '(') {
                // if we still have openBrackets, which means the currChar is not the outer parentheses, it's the
                // inner parentheses, we need to add it to the result
                if (openBrackets != 0) { // if openBrackets != 0, which means currChar is inner parentheses
                    sb.append(currChar);
                }
                // no matter it's inner or outer, if it's '(', the openBrackets need to plus one
                openBrackets++;

            // currChar == ')'
            } else {
                openBrackets--; // openBracket getting cancelled with close bracket
                if (openBrackets != 0) {//to check it's inner or not, if it's inner, we need to add it to the res
                    sb.append(currChar);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveOuterParentheses solution = new RemoveOuterParentheses();
        String S = "(()())(())";
        String res = solution.removeOuterParentheses(S);

        System.out.print(res);
    }
}


