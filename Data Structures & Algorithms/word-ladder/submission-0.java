class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>words=new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;
        Queue<String>q=new LinkedList<>();
        q.add(beginWord);
        int steps=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word=q.poll();
                if(word.equals(endWord)) return steps;

                char[] wordchars=word.toCharArray();
                for(int j=0;j<word.length();j++){
                    char originalcharacter=wordchars[j];
                    for(char c='a';c<='z';c++){
                        wordchars[j]=c;
                        String newWord=new String(wordchars);
                        if(words.contains(newWord)){
                            q.add(newWord);
                            words.remove(newWord);
                        }
                    }
                    wordchars[j]=originalcharacter;
                }
            }
             steps++;
        }
        return 0;
    }
}
