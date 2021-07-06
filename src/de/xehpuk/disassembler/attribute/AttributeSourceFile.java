package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import de.xehpuk.disassembler.util.Util;

public class AttributeSourceFile implements Attribute {
	public static final int LENGTH = 2;
	private final ConstantUtf8 sourceFile;

	public AttributeSourceFile(final ConstantUtf8 sourceFile) {
		this.sourceFile = sourceFile;
	}

	public ConstantUtf8 getSourceFile() {
		return sourceFile;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.SOURCE_FILE;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print(getName().getName() + '=');
		sourceFile.dump(0);
		System.out.println();
	}
}