package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DStore0 extends DStoreAbstract {
	protected DStore0() {
		super(0);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.DSTORE_0;
	}
}