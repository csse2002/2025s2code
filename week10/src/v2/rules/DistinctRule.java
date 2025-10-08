package v2.rules;

import draft.Course;

import java.util.*;

public class DistinctRule implements ProgramRules {
    private List<ConsumingRule> rules;

    public DistinctRule(ConsumingRule... rules) {
        this.rules = Arrays.stream(rules).toList();
    }

    private class Allocation {
        Map<String, List<Course>> mapping = new HashMap<>();

        public Allocation() {
            this.mapping = new HashMap<>();
            for (ConsumingRule rule : rules) {
                this.mapping.put(rule.identifier(), new ArrayList<>());
            }
        }

        public Allocation allocateTo(Course course, ConsumingRule rule) {
            Allocation newAllocation = new Allocation();
            for (String ruleID : mapping.keySet()) {
                newAllocation.mapping.put(ruleID, new ArrayList<>(mapping.get(ruleID)));
            }
            newAllocation.mapping.get(rule.identifier()).add(course);
            return newAllocation;
        }

        public boolean satisfiesAll() {
            for (ConsumingRule rule : rules) {
                if (!rule.satisfies(mapping.get(rule.identifier()))) {
                    return false;
                }
            }
            return true;
        }

    }

    @Override
    public boolean satisfies(List<Course> courses) {
        Allocation allocation = new Allocation();
        return backtrack(new HashSet<>(courses), allocation);
    }

    private boolean backtrack(Set<Course> courses, Allocation allocation) {
        if (allocation.satisfiesAll()) {
            System.out.println(allocation.mapping);
            return true;
        }
        for (Course current : courses) {
            for (ConsumingRule rule : rules) {
                if (!rule.canCountToward(current)) {
                    continue;
                }
                Set<Course> remaining = new HashSet<>(courses);
                remaining.remove(current);
                if (backtrack(remaining, allocation.allocateTo(current, rule))) {
                    return true;
                }
            }
        }
        return false;
    }
}
