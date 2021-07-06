package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FStore0 extends FStoreAbstract {
	protected FStore0() {
		super(0);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.FSTORE_0;
	}
}