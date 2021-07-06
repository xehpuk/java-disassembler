package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public class AttributeBootstrapMethods implements Attribute {
	private final BootstrapMethodsTableEntry[] bootstrapMethods;

	public AttributeBootstrapMethods(final BootstrapMethodsTableEntry[] bootstrapMethods) {
		this.bootstrapMethods = bootstrapMethods;
	}

	public BootstrapMethodsTableEntry[] getBootstrapMethods() {
		return bootstrapMethods;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.BOOTSTRAP_METHODS;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(getName().getName() + ':');
		for (final BootstrapMethodsTableEntry bootstrapMethod : bootstrapMethods) {
			bootstrapMethod.dump(indent + 1);
		}
	}
}