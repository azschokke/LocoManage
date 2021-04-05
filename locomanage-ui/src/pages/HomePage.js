import React from "react";
import Page from "../components/universal/Page"

const HomePage = () => 
{
    return (<Page>
        <div className="main">
            <h1>Welcome to LocoManage!</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget erat ante. Morbi luctus lacus et faucibus volutpat. Quisque in rhoncus ligula, ut facilisis ante. Donec porta porttitor metus. Etiam nec pulvinar nibh. In ullamcorper ultricies metus nec rhoncus. Vivamus et nulla vel odio fermentum pulvinar eu a massa. Integer consequat turpis eget egestas feugiat. Morbi sit amet enim in est sodales sollicitudin. Nam porttitor gravida lacus, scelerisque vulputate ligula iaculis sed. Integer ac lacinia augue. Suspendisse massa felis, suscipit eget condimentum a, blandit id diam.</p>

            <img src="../images/train.jpg" alt="" />

            <p>Donec venenatis, ligula id facilisis euismod, dolor risus eleifend eros, sed semper ante quam id dui. Pellentesque sed malesuada purus, nec vulputate felis. Fusce posuere et augue ac ultrices. Integer venenatis quis velit vitae accumsan. Quisque orci urna, tempus sed mauris quis, sodales fringilla lacus. Vestibulum sodales egestas risus, luctus aliquet tellus tincidunt pulvinar. Vivamus blandit lorem eu nulla laoreet placerat. Cras non ultricies nisl. Ut lorem augue, tristique ut urna at, efficitur dapibus velit. Sed rutrum pretium nisi, gravida consequat enim tincidunt sed. Nunc bibendum urna eros, at rutrum augue dapibus et. Praesent a lectus placerat, iaculis dui in, mattis purus. Nunc non hendrerit ante. Proin tempor molestie nisi id ullamcorper.</p>

            <p>Etiam ultricies tempus ex nec fermentum. Maecenas id ante vitae nisi egestas blandit. Nulla tempor diam nibh, eu pellentesque diam mattis nec. Nullam luctus eros risus, id suscipit nunc maximus id. Pellentesque efficitur ligula risus, et tristique lorem viverra sed. Mauris dapibus id eros et malesuada. Pellentesque interdum congue porttitor. Phasellus efficitur urna et auctor vulputate. Nullam nisi justo, convallis nec pretium eu, lacinia at quam. Nunc tempor eleifend ligula nec varius. Curabitur porttitor tellus in pellentesque eleifend. Etiam eu tincidunt massa.</p>
            <img className="gif" src="https://media.giphy.com/media/hqm2bYw6pY3F1ylAWg/giphy.gif" alt="" />
        </div>
    </Page>);
};
export default HomePage;