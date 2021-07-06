package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.Dumpable;
import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public class ParameterAnnotationTableEntry implements Dumpable {
	private final AnnotationTableEntry[] annotations;

	public ParameterAnnotationTableEntry(final AnnotationTableEntry[] annotations) {
		this.annotations = annotations;
	}

	public int getNumberOfAnnotations() {
		return annotations.length;
	}

	public AnnotationTableEntry[] getAnnotations() {
		return annotations;
	}

	@Override
	public String toString() {
		return "ParameterAnnotationTableEntry{" + annotations + '}';
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println("AnnotationTable:");
		for (final AnnotationTableEntry annotationTableEntry : annotations) {
			annotationTableEntry.dump(indent + 1);
		}
	}
}