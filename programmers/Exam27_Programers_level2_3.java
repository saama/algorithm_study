package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Exam27_Programers_level2_3 {
//	프로그래머스 summer/winter coding(2018) 스킬트리
// 	https://programmers.co.kr/learn/courses/30/lessons/49993
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
			if(f(skill,skill_trees[i])) {
				answer++;
			}
		}
        return answer;
    }
    public boolean f(String skill,String compSkill) {
    	List<Integer>skillSeq = new ArrayList<>();
    	List<String>noSkills = new ArrayList<>();
    	for (int i = 0; i < skill.length(); i++) {
    		//C B D
			String w = Character.toString(skill.charAt(i));
			if(compSkill.indexOf(w)!=-1) {
				//안배운 스킬중에서 현재스킬의 선행스킬이 있는지 체크
				int curIdx = skill.indexOf(w);
				for (int j = 0; j < noSkills.size(); j++) {
					 if(skill.indexOf(noSkills.get(j))<curIdx){
						 return false;
					 }
				}
				//선행스킬 체크 끝
				skillSeq.add(compSkill.indexOf(w));
			}else {
				//안배운스킬 넣어줌
				noSkills.add(w);
			}
		}
    	return f2(skillSeq);
    }
    //스킬리스트 선행순서 체크
    public boolean f2(List<Integer> skillSeq) {
    	if(skillSeq.size()>0) {
	    	int f = skillSeq.get(0);
	    	for (int i = 1; i < skillSeq.size(); i++) {
				if(f<skillSeq.get(i)) {
					f = skillSeq.get(i);
				}else {
					return false;
				}
			}
    	}
    	return true;
    }
	
	public static void main(String[] args) {
		Exam_27 e = new Exam_27();
		String skill = "CBD";
		String []skill_trees = {"CDA", "ASF", "BDF", "CEFD"};
		System.out.println(e.solution(skill,skill_trees));
	}
}
