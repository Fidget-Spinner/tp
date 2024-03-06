package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    // Retrieved from https://github.com/se-edu/addressbook-level3/commit/dc6d5139d08f6403da0ec624ea32bd79a2ae0cbf#diff-a8e35af8f9c251525063fae36c9852922a7e7195763018eacec60f3a4d87c594
    // Full credits to them.
    // Also following tutorial from https://nus-cs2103-ay2324s2.github.io/tp/tutorials/AddRemark.html.
    public static final Prefix PREFIX_REMARK = new Prefix("r/");

}
