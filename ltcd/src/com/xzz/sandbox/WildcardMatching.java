package com.xzz.sandbox;

import com.xzz.util.Timing;

public class WildcardMatching {

    /**
     * @param args
     */
    public static void main(String[] args) {
        _t.reset();
        // "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
        // "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"
        System.out
                .println(new WildcardMatching()
                        .isMatch2(
                                // "aa", "a"

                                // "bbbbaaaaaaabbaabababababbbbbabbbabbabbabbbabbaababbaabbbaaaababbbaaaaabbbbaaabaaabaaabbabaabababaabababababbbbbbabbaaaaaaababbbbaabbabbabababbbbaabbabbbbabbbbabbaaabaaaabaaabbbbbababaabababbaabaaaaaab",
                                // "*a*abab**b*aaa**a****a***aab*babb*b***b*a**babaaa*a***ab*b*b****ba*a*a****a**ba**a*****a*b*b*abaa*a*"
                                "aaabbbbaaaabbabbbbaabbabaaababaababaaaaaaabaaababbaababbaababbbaaaaabaabbabbaabaababbaabababbbbbbbbabbaabbaaabaababaabaababababababbbbbbabbabbaabbaabaaaaaababaabbbaaabaaabbbbbbbbbaabaabaaabaaabbabbabb",
                                "****a*b*b**b*bbb*b**bba***b**b*b*b**ba***b*b*a*b*b*****a**aaa*baaa*ba*****a****ba*a****a**b*******a*a"
                        // "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                        // "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"
                        ));
        _t.check("end");

    }

    public boolean isMatch3(String s, String p) {
        int spos = 0;
        int ppos = 0;
        int star = -1;
        int starPos = -1;

        while (spos < s.length()) {
            if (ppos < p.length() && 
                    (s.charAt(spos) == p.charAt(ppos) || p.charAt(ppos) == '?')) {
                spos++;
                ppos++;
            } else if (ppos < p.length() && p.charAt(ppos) == '*') {
                star = ppos++;
                starPos = spos;
            } else if (star >= 0) {
                ppos = star + 1;
                spos = ++starPos;
            } else {
                return false;
            }
        }
        return (ppos == p.length() || allStarsMatch(p.toCharArray(), ppos));
    }

    byte[][] isMatchCache;

    static Timing _t = new Timing();

    private boolean allStarsMatch(char[] p, int ppos) {
        for (int i = ppos; i < p.length; ++i) {
            if (p[i] != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean isMatch2(String s, String p) {

        p = preProcessPattern(p);
        byte[][] cache = new byte[s.length() + 1][(p.length() + 8) / 8];

        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();

        setCacheHit(cache, s.length(), p.length());

        for (int pp = p.length() - 1; pp >= 0; --pp) {
            if (chp[pp] == '*' && cacheHit(cache, s.length(), pp + 1)) {
                setCacheHit(cache, s.length(), pp);
            } else {
                break;
            }
        }

        setCacheHit(cache, s.length(), p.length());

        for (int pp = p.length() - 1; pp >= 0; --pp) {
            for (int ps = s.length() - 1; ps >= 0; --ps) {
                if (chp[pp] == '*') {
                    int k = 0;
                    for (; k + ps <= s.length(); k++) {
                        if (cacheHit(cache, k + ps, pp + 1)) {
                            setCacheHit(cache, ps, pp);
                            break;
                        }
                    }
                } else {
                    if ((chs[ps] == chp[pp] || chp[pp] == '?') && cacheHit(cache, ps + 1, pp + 1)) {
                        setCacheHit(cache, ps, pp);
                    }
                }
            }
        }

        return cacheHit(cache, 0, 0);
    }

    public boolean isMatch(String s, String p) {
        p = preProcessPattern(p);
        if (p.length() == 0) {
            return s.length() == 0;
        }

        isMatchCache = new byte[s.length()][(p.length() + 7) / 8];
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private String preProcessPattern(String p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); ++i) {
            if (i > 0 && p.charAt(i - 1) == p.charAt(i) && p.charAt(i) == '*') {
                continue;
            }
            sb.append(p.charAt(i));
        }
        return sb.toString();
    }

    private boolean cacheHit(byte[][] cache, int spos, int ppos) {
        int p1 = ppos >> 3;
        int p2 = ppos & 7;
        return (cache[spos][p1] & (1 << p2)) > 0;
    }

    private void setCacheHit(byte[][] cache, int spos, int ppos) {
        int p1 = ppos >> 3;
        int p2 = ppos & 7;
        cache[spos][p1] |= (1 << p2);
    }

    private boolean isMatch(char[] s, int spos, char[] p, int ppos) {

        if (spos == s.length) {
            return ppos == p.length || allStarsMatch(p, ppos);
        }
        if (ppos == p.length) {
            return false;
        }

        if (cacheHit(isMatchCache, spos, ppos)) {
            return false;
        }

        if (p[ppos] == '?') {
            return isMatch(s, spos + 1, p, ppos + 1);
        }
        if (p[ppos] == '*') {
            for (int s2 = spos; s2 <= s.length; ++s2) {
                if (isMatch(s, s2, p, ppos + 1)) {
                    // isMatchCache[spos][ppos] = 2;
                    return true;
                }
            }
            setCacheHit(isMatchCache, spos, ppos);
            return false;
        }
        boolean retval = s[spos] == p[ppos] && isMatch(s, spos + 1, p, ppos + 1);
        if (!retval) {
            setCacheHit(isMatchCache, spos, ppos);
        }
        return retval;
    }

}
