package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public abstract class AttributeAnnotations implements Attribute {
	private final AnnotationTableEntry[] annotations;

	public AttributeAnnotations(final AnnotationTableEntry[] annotations) {
		this.annotations = annotations;
	}

	public AnnotationTableEntry[] getAnnotations() {
		return annotations;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(getName().getName() + ':');
		for (final AnnotationTableEntry annotationTableEntry : annotations) {
			annotationTableEntry.dump(indent + 1);
		}
	}
}