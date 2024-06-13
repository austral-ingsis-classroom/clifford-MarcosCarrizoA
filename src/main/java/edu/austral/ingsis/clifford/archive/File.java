package edu.austral.ingsis.clifford.archive;

public class File implements Component {
    private final String name;
    private final Dir parent;

    public File(String name, Dir parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Component getParent() {
        return parent;
    }

    @Override
    public boolean isComposite() {
        return false;
    }
}
