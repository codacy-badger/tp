package seedu.address.testutil.internship;

import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_COMPANY_NAME_FACEBOOK;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_COMPANY_NAME_GOLDMAN;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_COMPANY_NAME_LAZADA;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_COMPANY_NAME_SHOPEE;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_JOB_TITLE_DA;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_JOB_TITLE_DS;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_JOB_TITLE_FE;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_JOB_TITLE_SWE;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_PERIOD_MAY_TO_JULY;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_PERIOD_SUMMER;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_PERIOD_THREE_MONTHS;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_PERIOD_TWO_MONTHS;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_REQUIREMENT_PYTHON;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_REQUIREMENT_RN;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_REQUIREMENT_TENSOR;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_WAGE_2000;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_WAGE_3000;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_WAGE_3500;
import static seedu.address.testutil.internship.InternshipItemFieldsUtil.VALID_WAGE_4000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.internship.InternshipItem;
import seedu.address.model.item.ItemList;

/**
 * A utility class containing a list of {@code InternshipItem} objects to be used in tests.
 */
public abstract class SampleInternshipItems {

    public static final InternshipItem SHOPEE_SWE = new InternshipItemBuilder()
            .withCompanyName(VALID_COMPANY_NAME_SHOPEE)
            .withJobTitle(VALID_JOB_TITLE_SWE)
            .withWage(VALID_WAGE_2000)
            .withPeriod(VALID_PERIOD_TWO_MONTHS)
            .withRequirements(VALID_REQUIREMENT_RN)
            .build();
    public static final InternshipItem LAZADA_DS = new InternshipItemBuilder()
            .withCompanyName(VALID_COMPANY_NAME_LAZADA)
            .withJobTitle(VALID_JOB_TITLE_DS)
            .withWage(VALID_WAGE_3000)
            .withPeriod(VALID_PERIOD_THREE_MONTHS)
            .withRequirements(VALID_REQUIREMENT_PYTHON, VALID_REQUIREMENT_TENSOR)
            .build();
    public static final InternshipItem FACEBOOK_FE = new InternshipItemBuilder()
            .withCompanyName(VALID_COMPANY_NAME_FACEBOOK)
            .withJobTitle(VALID_JOB_TITLE_FE)
            .withWage(VALID_WAGE_3500)
            .withPeriod(VALID_PERIOD_MAY_TO_JULY)
            .build();
    public static final InternshipItem GOLDMAN_DA = new InternshipItemBuilder()
            .withCompanyName(VALID_COMPANY_NAME_GOLDMAN)
            .withJobTitle(VALID_JOB_TITLE_DA)
            .withWage(VALID_WAGE_4000)
            .withPeriod(VALID_PERIOD_SUMMER)
            .build();

    /**
     * Returns an {@code ItemList<InternshipItem>} with all the sample internship items.
     */
    public static ItemList<InternshipItem> getSampleInternshipList() {
        ItemList<InternshipItem> internshipItemList = new ItemList<>();
        for (InternshipItem internshipItem : getInternshipItems()) {
            internshipItemList.addItem(internshipItem);
        }
        return internshipItemList;
    }

    private static List<InternshipItem> getInternshipItems() {
        return new ArrayList<>(Arrays.asList(SHOPEE_SWE, LAZADA_DS, FACEBOOK_FE, GOLDMAN_DA));
    }
}