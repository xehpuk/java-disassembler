package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LStore0 extends LStoreAbstract {
	protected LStore0() {
		super(0);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.LSTORE_0;
	}
}