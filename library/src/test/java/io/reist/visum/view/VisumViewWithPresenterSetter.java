package io.reist.visum.view;

import io.reist.visum.presenter.TestPresenter;

/**
 * Created by Reist on 07.06.16.
 */
interface VisumViewWithPresenterSetter extends VisumView<TestPresenter> {

    void setPresenter(TestPresenter testPresenter);

}
