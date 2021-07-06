package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LStore3 extends LStoreAbstract {
	protected LStore3() {
		super(3);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.LSTORE_3;
	}
}