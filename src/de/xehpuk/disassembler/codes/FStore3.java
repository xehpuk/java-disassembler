package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FStore3 extends FStoreAbstract {
	protected FStore3() {
		super(3);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.FSTORE_3;
	}
}